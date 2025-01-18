package com.ufrn.isp.api.service;

import com.ufrn.isp.api.domain.Complaint;
import com.ufrn.isp.api.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
        Complaint existingComplaint = getComplaintById(id);
        existingComplaint.setDescricao(updatedComplaint.getDescricao());
        existingComplaint.setStatus(updatedComplaint.getStatus());
        return complaintRepository.save(existingComplaint);
    }

    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
