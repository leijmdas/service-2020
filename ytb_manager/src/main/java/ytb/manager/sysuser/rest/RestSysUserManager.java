package ytb.manager.sysuser.rest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ytb.common.basic.safecontext.service.SafeContext;
import ytb.common.test.demo.Student;
import ytb.common.utils.YtbUtils;

import ytb.manager.sysuser.rest.impl.SysPower;
import ytb.manager.sysuser.rest.impl.SysRole;
import ytb.manager.sysuser.rest.impl.SysUser;
import ytb.manager.sysuser.service.impl.SysUserContext;
import ytb.common.context.rest.IRestProcess;
import ytb.common.RestMessage.MsgHandler;
import ytb.common.RestMessage.MsgResponse;
import ytb.common.context.model.YtbError;

import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理系统的Rest类
 * Package: ytb.manager.sysuser.rest
 * Author: ZCS
 * Date: Created in 2018/8/21 13:20
 * Copyright: Copyright (c) 2018
 */

@RestController
@RequestMapping("/rest")
//@Scope("prototype")
public class RestSysUserManager implements IRestProcess {

    @Autowired
    Student student;

    @PostMapping(value = "sysuser", produces = {"application/json;charset=UTF-8"})
    public MsgResponse sysUserRest(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("sysUserRest");
        return new MsgHandler(new SysUserContext()).parse (this, data, request, response);
    }

    @GetMapping("query/{id}")
    public JsonResult<Integer> qry(@PathVariable("id") Integer id) {
        JsonResult<Integer> result = new JsonResult<>();
        result.setData(id);
        return result;
    }

    @GetMapping("qp")
    public JsonResult<Student> qryParam(@RequestParam("a") Integer a, @RequestParam("b") String b) {
        student.setName("leijm");
        student.setAge(45);
        JsonResult<Student> result = new JsonResult<>();
        result.setData(student);
        result.setMsg(b);
        return result;
    }

    public MsgResponse process(MsgHandler handler, HttpServletRequest request, HttpServletResponse response) {
        if (handler.req.cmdtype.equals("user") && handler.req.cmd.equals("login")) {

        } else {
            handler.getUserContext().setLoginSso(SafeContext.getLog_ssoAndApiKey(handler.req.token));
            handler.req.msgBody.put("login_userId", handler.getUserContext().getLoginSso().getUserId());
        }
        handler.req.msgBody.put("ip", YtbUtils.getIpAddr(request));

        if (handler.req.cmdtype.equals("user")) {
            return new SysUser().process(handler);
        } else if (handler.req.cmdtype.equals("role")) {
            return new SysRole().process(handler);
        } else if (handler.req.cmdtype.equals("menu")) {
            return new SysPower().process(handler);
        }

        throw new YtbError(YtbError.CODE_INVALID_REST);
    }


}




