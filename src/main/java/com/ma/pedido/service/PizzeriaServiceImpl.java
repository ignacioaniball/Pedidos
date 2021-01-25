package com.ma.pedido.service;

import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.entity.OrderDetail;
import com.ma.pedido.model.entity.Product;
import com.ma.pedido.model.request.OrderDetailRequest;
import com.ma.pedido.model.request.OrderRequest;
import com.ma.pedido.model.response.OrderDetailResponse;
import com.ma.pedido.model.response.OrderResponse;
import com.ma.pedido.service.jpa.OrderDetailService;
import com.ma.pedido.service.jpa.OrderService;
import com.ma.pedido.service.jpa.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PizzeriaServiceImpl.class);
    private String PENDINGSTATUS = "PENDIENTE";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    @Value("${order.discount}")
    public int descuento;
    @Value("${order.amountProduct}")
    public int productAmountForDiscount;

    @Autowired
    public ProductService productService;
    @Autowired
    public OrderService orderService;
    @Autowired
    public OrderDetailService orderDetailService;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        List<OrderDetail> orderDetailList = populateOrderDetail(orderRequest);
        Order order = populateOrder(orderRequest, orderDetailList);
        orderService.save(order);
        for (OrderDetail element : orderDetailList) {
            element.setOrder(order);
            orderDetailService.save(element);
        }
        return populateOrderResponse(order, orderDetailList);
    }

    @Override
    public List<Order> getOrderList(String date) {
        return orderService.findByDate(dateParse(date));
    }

    private Double calcularDescuento(Double priceTotal) {
         return priceTotal - (descuento * priceTotal / 100);
    }

    private List<OrderDetail> populateOrderDetail(OrderRequest orderRequest) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (OrderDetailRequest elements : orderRequest.getDetalle()) {
            try {
                if (elements.getCantidad() == 0) {
                    throw new NullPointerException();
                } else {
                    OrderDetail orderDetail = new OrderDetail();
                    Product product = productService.findOne(elements.getProducto());
                    orderDetail.setProducto(product);
                    orderDetail.setProductId(product.getIdProducto());
                    orderDetail.setCantidad(elements.getCantidad());
                    orderDetail.setImporte(elements.getCantidad() * product.getPrecioUnitario());
                    orderDetailList.add(orderDetail);
                }
            } catch (NullPointerException e) {
                LOGGER.info("La variable cantidad, no puede ser null.", e);
            }
        }
        return orderDetailList;
    }

    private Order populateOrder(OrderRequest orderRequest, List<OrderDetail> orderDetailList) {
        Order order = new Order();
        int productTotal = 0;
        double priceTotal = 0;
        for (OrderDetail elements : orderDetailList) {
            productTotal += elements.getCantidad();
            priceTotal += elements.getImporte();
        }
        order.setFecha(dateParse(LocalDate.now().toString()));
        order.setDireccion(orderRequest.getDireccion());
        order.setEmail(orderRequest.getEmail());
        order.setTelefono(orderRequest.getTelefono());
        order.setHorario(orderRequest.getHorario());
        order.setEstado(PENDINGSTATUS);
        if (productTotal >= productAmountForDiscount) {
            order.setDescuento(true);
            order.setTotal(calcularDescuento(priceTotal));
        } else {
            order.setDescuento(false);
            order.setTotal(priceTotal);
        }
        return order;
    }

    private OrderResponse populateOrderResponse(Order order, List<OrderDetail> orderDetailList) {
        OrderResponse orderResponse = new OrderResponse(order);
        orderResponse.setFecha(order.getFecha());
        orderResponse.setDireccion(order.getDireccion());
        orderResponse.setEmail(order.getEmail());
        orderResponse.setTelefono(order.getTelefono());
        orderResponse.setHorario(order.getTelefono());
        orderResponse.setTotal(order.getTotal());
        orderResponse.setDescuento(order.getDescuento());
        orderResponse.setEstado(order.getEstado());
        List<OrderDetailResponse> orderDetailListResponse = new ArrayList<>();
        for (OrderDetail element: orderDetailList) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setProducto(element.getProductId());
        orderDetailResponse.setNombre(element.getProducto().getNombreString());
        orderDetailResponse.setCantidad(element.getCantidad());
        orderDetailResponse.setImporte(element.getImporte());
        orderDetailListResponse.add(orderDetailResponse);
        }
        orderResponse.setDetalle(orderDetailListResponse);
        return orderResponse;
    }

    private Date dateParse(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        java.util.Date dateParse = null;
        try {
            if (StringUtils.isEmpty(date)) {
                throw new NullPointerException("The date date can not be empty.");
            }
            dateParse = format.parse(String.valueOf(date));
        } catch (ParseException e) {
            LOGGER.error("Error parsing {} variable.", date);
        } catch (NullPointerException e) {
            LOGGER.error("The variable {} can not be null", date);
        }
        return dateParse;
    }
}
