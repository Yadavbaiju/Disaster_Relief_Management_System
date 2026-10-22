package com.disaster.relief.service;

import com.disaster.relief.model.*;
import com.disaster.relief.repository.SupplyRepository;
import com.disaster.relief.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReliefService {

    private final WorkerRepository workerRepository;
    private final SupplyRepository supplyRepository;

    public ReliefService(WorkerRepository workerRepository, SupplyRepository supplyRepository) {
        this.workerRepository = workerRepository;
        this.supplyRepository = supplyRepository;
    }

    // Dynamic Method Dispatch across all volunteers (Medical, Rescue, Food)
    public List<String> deployAllWorkers() {
        List<String> deploymentLogs = new ArrayList<>();
        List<ReliefWorker> workers = workerRepository.findAll();
        
        for (ReliefWorker worker : workers) {
            deploymentLogs.add(worker.assignTask());
        }
        
        return deploymentLogs;
    }

    public void addWorker(ReliefWorker worker) {
        workerRepository.save(worker);
    }

    public void addSupply(Supply supply) {
        supplyRepository.save(supply);
    }

    public List<Supply> getSupplies() {
        return supplyRepository.findAll();
    }
}