package com.disaster.relief.repository;

import com.disaster.relief.model.ReliefWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<ReliefWorker, String> {
}