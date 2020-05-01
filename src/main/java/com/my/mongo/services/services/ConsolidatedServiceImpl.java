package com.my.mongo.services.services;

import com.my.mongo.services.entity.*;
import com.my.mongo.services.model.ConsolidatedAgentDetail;
import com.my.mongo.services.model.ConsolidatedContact;
import com.my.mongo.services.model.ConsolidatedInsured;
import com.my.mongo.services.model.ConsolidatedLossDetail;
import com.my.mongo.services.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Javalingappa
 */

@Service
public class ConsolidatedServiceImpl implements IConsolidatedService {

    @Autowired
    ConsolidatedRepository consolidatedRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    AgentaDetailRepository agentaDetailRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    InsuredRepository insuredRepository;

    @Autowired
    LossDetailRepository lossDetailRepository;

    @Override
    public List<Consolidated> generateConsolidatedClaims() {
        return consolidatedRepository.findAll();
    }

    @Override
    public Consolidated generateConsolidatedClaims(String agentId) {

        return consolidatedRepository.save(getConsolidatedAgentDetails(agentId));

    }

    private Consolidated getConsolidatedAgentDetails(String agentId) {
        Consolidated consolidated = new Consolidated();
        Agent agent = agentRepository.findById(agentId).get();
        if (agent != null) {
            consolidated.setId(agentId);
            consolidated.setName(agent.getName());
            consolidated.setContactName(agent.getContactName());
            consolidated.setEmail(agent.getEmail());
            consolidated.setPhone(agent.getPhone());
            consolidated.setAddress(agent.getAddress());
            consolidated.setLossDetails(getLossDetailList(agentId));
        }
        consolidated.setContacts(getContactList(agentId));
        consolidated.setAgentDetails(getAgentDetailList(agentId));
        consolidated.setInsureds(getInsuredList(agentId));
        return consolidated;

    }

    private List<ConsolidatedLossDetail> getLossDetailList(String agentId) {
        return convertToModelLossDetail(lossDetailRepository.findAllByAgentId(agentId));
    }

    private List<ConsolidatedLossDetail> convertToModelLossDetail(List<LossDetail> ldList) {
        List<ConsolidatedLossDetail> list = new ArrayList<>();
        for (com.my.mongo.services.entity.LossDetail ld : ldList) {
            ConsolidatedLossDetail obj = new ConsolidatedLossDetail();
            obj.setIsLost(ld.getIsLost());
            obj.setLossDetailNumber(ld.getLossDetailNumber());
            obj.setLossLocation(ld.getLossLocation());
            list.add(obj);
        }
        return list;
    }

    private List<ConsolidatedInsured> getInsuredList(String agentId) {
        return convertToModelInsured(insuredRepository.findAllByAgentId(agentId));
    }

    private List<ConsolidatedInsured> convertToModelInsured(List<Insured> insuredList) {
        List<ConsolidatedInsured> list = new ArrayList<>();
        for (com.my.mongo.services.entity.Insured insured : insuredList) {
            ConsolidatedInsured obj = new ConsolidatedInsured();
            obj.setInsuredNumber(insured.getInsuredNumber());
            obj.setPlace(insured.getPlace());
            obj.setType(insured.getType());
            list.add(obj);
        }
        return list;
    }

    private List<ConsolidatedAgentDetail> getAgentDetailList(String agentId) {
        return convertToModelAgentdetail(agentaDetailRepository.findAllByAgentId(agentId));
    }

    private List<ConsolidatedAgentDetail> convertToModelAgentdetail(List<AgentDetail> adList) {
        List<ConsolidatedAgentDetail> list = new ArrayList<>();
        for (com.my.mongo.services.entity.AgentDetail agentDetail : adList) {
            ConsolidatedAgentDetail obj = new ConsolidatedAgentDetail();
            obj.setAdNumber(agentDetail.getAdNumber());
            obj.setDetails(agentDetail.getDetails());
            obj.setState(agentDetail.getDetails());
            list.add(obj);
        }
        return list;
    }

    private List<ConsolidatedContact> getContactList(String agentId) {
        return convertToModelContact(contactRepository.findAllByAgentId(agentId));
    }

    private List<ConsolidatedContact> convertToModelContact(List<Contact> contactList) {
        List<ConsolidatedContact> list = new ArrayList<>();
        for (com.my.mongo.services.entity.Contact contact : contactList) {
            ConsolidatedContact obj = new ConsolidatedContact();
            obj.setFax(contact.getFax());
            obj.setMobile(contact.getMobile());
            obj.setPostalAddress(contact.getPostalAddress());
            list.add(obj);
        }
        return list;
    }


}
