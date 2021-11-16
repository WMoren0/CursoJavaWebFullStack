/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.springboot.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Willian
 */

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
