package com.kir.demo.contorllers;


import com.kir.demo.models.Bucket;
import com.kir.demo.repositories.BucketRepository;
import com.kir.demo.services.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    BucketRepository bucketRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model){

        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = new PageRequest(0, 3, sort);
        Page<Bucket> blogs = bucketRepository.findAll(pageable);
        model.addAttribute("latestPosts", blogs);
        return "home";
    }
}
