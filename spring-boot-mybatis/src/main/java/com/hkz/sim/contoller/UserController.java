package com.hkz.sim.contoller;

import com.hkz.sim.domain.User;
import com.hkz.sim.json.JsonResult;
import com.hkz.sim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huangkz on 2018/6/22.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") int id) {
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setObject(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setObject(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(int id){
        JsonResult r = new JsonResult();
        try{
            int result = userService.delete(id);
            if(result > 0){
                r.setStatus("ok");
                r.setObject(result);
            }else {
                r.setObject(result);
                r.setStatus("fail");
            }
        }catch (Exception e){
            r.setObject(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
        }
        return  ResponseEntity.ok(r);
    }


}
