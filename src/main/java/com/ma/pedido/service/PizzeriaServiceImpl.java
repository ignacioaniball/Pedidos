package com.ma.pedido.service;

import com.ma.pedido.model.entity.OrderDetail;
import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.entity.Product;
import com.ma.pedido.model.response.OrderDetailResponse;
import com.ma.pedido.model.response.OrderResponse;
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
import java.util.Locale;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PizzeriaServiceImpl.class);
    private String PENDINGSTATUS = "PENDIENTE";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    @Value("${order.discount}")
    public int descuento;
    @Value("${order.amountProduct}")
    public int productAmountDiscount;

    @Autowired
    public ProductService productoService;
    @Autowired
    public OrderService pedidoCabeceraService;

    @Override
    public OrderResponse createPedido(Order order) {
        OrderResponse orderResponse = compleDetalle(order);
        orderResponse.setTotal(calcularDescuento(orderResponse));
        pedidoCabeceraService.save(order);
        return orderResponse;
    }

    @Override
    public List<String> listarPedidoCabecera(String fecha) {
        pedidoCabeceraService.findAll();
        return null;
    }

    private Double calcularDescuento(OrderResponse orderResponse) {
        if (orderResponse.getDescuento()) {
            Double porcentajeDescuento = descuento * orderResponse.getTotal() / 100;
            return orderResponse.getTotal() - porcentajeDescuento;
        }
        return orderResponse.getTotal();
    }

    private OrderResponse compleDetalle(Order order) {
        double priceTotal = 0;
        double productTotal = 0;
        List<OrderDetailResponse> productList = new ArrayList();
        OrderResponse orderResponse = new OrderResponse();
        for (OrderDetail elements : order.getDetalle()) {
            try {
                if (elements.getCantidad() == 0) {
                    throw new NullPointerException();
                } else {

                    productTotal += elements.getCantidad();

                    Product product = productoService.findOne(elements.getProducto());
                    Double productPrice = product.getPrecioUnitario();
                    priceTotal += elements.getCantidad() * productPrice;
                    OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                    orderDetailResponse.setCantidad(elements.getCantidad());
                    orderDetailResponse.setImporte(product.getPrecioUnitario()*elements.getCantidad());
                    orderDetailResponse.setNombre(product.getNombreString());
                    orderDetailResponse.setProducto(product.getIdProducto());
                    productList.add(orderDetailResponse);
                }
            } catch (NullPointerException e) {
                LOGGER.info("La variable cantidad, no puede ser null.", e);
            }
        }
        if (productTotal >= productAmountDiscount) {
            orderResponse.setDescuento(true);
        }else {
            orderResponse.setDescuento(false);
        }
        orderResponse.setEstado(PENDINGSTATUS);
        orderResponse.setDescuento(productTotal >= productAmountDiscount);
        orderResponse.setFecha(dateParse(LocalDate.now()).toString());
        orderResponse.setTotal(priceTotal);
        orderResponse.setEmail(order.getEmail());
        orderResponse.setDireccion(order.getDireccion());
        orderResponse.setTelefono(order.getTelefono());
        orderResponse.setHorario(order.getHorario());
        orderResponse.setDetalle(productList);
        return orderResponse;
    }

    private Date dateParse(LocalDate localDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        java.util.Date publishedParse = null;
        try {
            if (StringUtils.isEmpty(localDate)) {
                throw new NullPointerException("The localDate date can not be empty.");
            }
            publishedParse = format.parse(String.valueOf(localDate));
        } catch (ParseException e) {
            LOGGER.error("Error parsing {} variable.", localDate);
        } catch (NullPointerException e) {
            LOGGER.error("The variable {} can not be null", localDate);
        }
        return publishedParse;
    }

    private void validateVariable(){

    }
}
