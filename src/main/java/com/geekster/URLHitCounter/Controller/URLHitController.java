package com.geekster.URLHitCounter.Controller;

import com.geekster.URLHitCounter.Service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class URLHitController {

        private UrlHitService urlHitService;

        @Autowired
        public void UrlHitController(UrlHitService urlHitService) {
            this.urlHitService = urlHitService;
        }

        @GetMapping("count")
        public ResponseEntity<Map<String, Integer>> getHitCount() {
            int hitCount = urlHitService.getHitCount();
            Map<String, Integer> response = Collections.singletonMap("visitors", hitCount);
            return ResponseEntity.ok(response);
        }

        @GetMapping("username/{username}/count")
        public ResponseEntity<Map<String, Object>> getUserHitCount(@PathVariable("username") String username) {
            int userHitCount = urlHitService.getUserHitCount(username);
            Map<String, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("hitcount", userHitCount);
            return ResponseEntity.ok(response);
        }
    }
