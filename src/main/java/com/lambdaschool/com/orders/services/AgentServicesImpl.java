package com.lambdaschool.com.orders.services;

import com.lambdaschool.com.orders.models.Agent;
import com.lambdaschool.com.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServicesImpl implements AgentServices
{
    @Autowired
    private AgentsRepository agentRepos;

    @Override
    public Agent save(Agent agent)
    {
        return agentRepos.save(agent);
    }
}
