package com.fpt.vanguard.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dqqqjxnfh",
                "api_key", "255558816145194",
                "api_secret", "gfcwesLzyJVykvcuJIHctzOOuoU",
                "secure", true
        ));
    }
}
