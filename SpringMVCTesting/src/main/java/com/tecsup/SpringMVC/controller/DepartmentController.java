package com.tecsup.SpringMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.SpringMVC.exception.DAOException;
import com.tecsup.SpringMVC.model.Department;
import com.tecsup.SpringMVC.services.DepartmentService;
   
/**
 * Handles requests for the application home page.
 */
@Controller
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	
	@GetMapping("/admin/dpto/list")
	public String list(@ModelAttribute("SpringWeb") Department department, ModelMap model) {

		try {
			model.addAttribute("departments", departmentService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/dpto/list";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{department_id}")
	public ModelAndView home(@PathVariable int department_id, ModelMap model) {

		
		ModelAndView modelAndView = null;
		Department dpto = new Department();
		try {
			dpto = departmentService.find(department_id);
			logger.info(dpto.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView = new ModelAndView("home", "command", dpto);

		return modelAndView;
	}

	@GetMapping("/admin/dpto/{action}/{department_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int department_id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Department dpto = departmentService.find(department_id);
			logger.info(dpto.toString());
			modelAndView = new ModelAndView("admin/dpto/" + action, "command", dpto);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/dpto/" + action, "command", new Department());
		}

		return modelAndView;
	}

	@PostMapping("/admin/dpto/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Department dpto, ModelMap model) {

		logger.info("dpto = " + dpto);

		ModelAndView modelAndView = null;

		try {
			departmentService.update(dpto.getName(), dpto.getDesc(), dpto.getCity());

			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		}

		return modelAndView;
	}

	@PostMapping("/admin/dpto/delete")
	public ModelAndView delete(@ModelAttribute("SpringWeb") Department dpto, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			departmentService.delete(dpto.getName());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		}

		return modelAndView;
	}


	@GetMapping("/admin/dpto/createform")
	public ModelAndView createform() {

		Department dpto = new Department();

		ModelAndView modelAndView = new ModelAndView("admin/dpto/createform", "command", dpto);

		return modelAndView;
	}


	@PostMapping("/admin/dpto/create")
	public ModelAndView create(@ModelAttribute("SpringWeb") Department dpto, ModelMap model) {

		
		ModelAndView modelAndView = null;
		
		try {
			departmentService.create(dpto.getName(), dpto.getDesc(), dpto.getCity());
			logger.info("new Department login = " + dpto.getName());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (DAOException e) {
			logger.error(e.getMessage());
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/dpto/createform","command", dpto);
		}

		return modelAndView;
	}

}
