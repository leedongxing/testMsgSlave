/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: TestMessageController.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/9
 */

package com.ldx.msg.webapp.ctroller;

import com.ldx.msg.webservice.mq.NativeAmqCunsumer;
import com.ldx.msg.webservice.mq.SpringAmqCunsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-09 18:10
 * @lastdate:
 */

@Controller
@RequestMapping(value = "/mq")
public class TestMessageController {
    @Autowired
    private NativeAmqCunsumer nativeAmqCunsumer;
    @Autowired
    private SpringAmqCunsumer springAmqCunsumer;

    @RequestMapping(value = "/native/p2p/")
    public ModelAndView nativeP2p(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("send");
        String msg = nativeAmqCunsumer.recive();
        view.addObject("msg", msg);
        return view;
    }

    @RequestMapping(value = "/native/p2p/topic")
    public ModelAndView nativeP2pTopic(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("send");
        String msg = nativeAmqCunsumer.reciveTopic();
        view.addObject("msg", msg);
        return view;
    }

    @RequestMapping(value = "/spring/p2p/")
    public ModelAndView springP2p(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("send");
        String msg = springAmqCunsumer.recive();
        view.addObject("msg", msg);
        return view;
    }
}
