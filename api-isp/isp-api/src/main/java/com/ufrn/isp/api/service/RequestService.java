package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.Request;
import com.ufrn.isp.api.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request updatedRequest) {
        Request existingRequest = getRequestById(id);
        existingRequest.setTipoSolicitacao(updatedRequest.getTipoSolicitacao());
        existingRequest.setDescricao(updatedRequest.getDescricao());
        existingRequest.setStatus(updatedRequest.getStatus());
        existingRequest.setLocalizacao(updatedRequest.getLocalizacao());
        return requestRepository.save(existingRequest);
    }

    public void save(Request request) {
        requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
