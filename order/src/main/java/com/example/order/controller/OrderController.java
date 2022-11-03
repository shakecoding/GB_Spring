package com.example.order.controller;

import com.example.order.service.OrderSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {

    private final OrderSerive orderSerive;


}
