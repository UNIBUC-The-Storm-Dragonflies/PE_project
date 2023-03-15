package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.Projecting;
import ro.unibuc.hello.data.ProjectingRepository;
import ro.unibuc.hello.dto.ProjectingDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectingService {
    @Autowired
    ProjectingRepository projectingRepository;

    public List<String> getTicketIdsOfProjectingList(List<ProjectingDTO> projectings) {
        return projectings.stream().map(proj -> proj.getTicket_id())
                .collect(Collectors.toList());
    }
}
