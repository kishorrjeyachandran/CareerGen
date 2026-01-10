package com.careergen.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careergen.backend.model.CareerResponse;

@Service
public class CareerServiceImpl implements CareerService {
    @Override
public CareerResponse recommendCareer(List<String> skills) {

    int backend = 0;
    int frontend = 0;
    int devops = 0;
    int data = 0;

    for (String rawSkill : skills) {

        String skill = rawSkill.trim().toLowerCase();

        if (List.of("java", "spring boot", "sql", "rest api").contains(skill)) {
            backend++;
        }

        if (List.of("html", "css", "javascript", "react", "angular").contains(skill)) {
            frontend++;
        }

        if (List.of("docker", "aws", "kubernetes", "linux").contains(skill)) {
            devops++;
        }

        if (List.of("python", "machine learning", "data analysis").contains(skill)) {
            data++;
        }
    }

    if (devops > backend && devops > frontend && devops > data) {
        return new CareerResponse(
            "DevOps Engineer",
            List.of("Docker", "AWS", "Kubernetes", "Linux"),
            "Manages CI/CD pipelines, cloud infrastructure, and deployments"
        );
    }

    if (backend > frontend && backend > devops && backend > data) {
        return new CareerResponse(
            "Backend Developer",
            List.of("Java", "Spring Boot", "SQL"),
            "Builds scalable server-side applications"
        );
    }

    if (frontend > backend && frontend > devops && frontend > data) {
        return new CareerResponse(
            "Frontend Developer",
            List.of("HTML", "CSS", "JavaScript", "React"),
            "Builds responsive and interactive user interfaces"
        );
    }

    if (data > backend && data > frontend && data > devops) {
        return new CareerResponse(
            "Data Scientist",
            List.of("Python", "Machine Learning", "Data Analysis"),
            "Works on data-driven and AI-based solutions"
        );
    }

    if (devops > 0 || backend > 0 || frontend > 0 || data > 0) {
        return new CareerResponse(
            "Multi-Domain Software Engineer",
            List.of("Problem Solving", "Programming"),
            "You have skills across multiple domains. Consider specializing further."
        );
    }

    return new CareerResponse(
        "General Software Engineer",
        List.of("Problem Solving", "Programming"),
        "Select domain-specific skills to get a recommendation"
    );
}


}
