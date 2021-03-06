package org.orcid.core.manager.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.orcid.core.manager.StatisticsGeneratorManager;
import org.orcid.core.utils.statistics.StatisticsEnum;
import org.orcid.persistence.dao.StatisticsGeneratorDao;

public class StatisticsGeneratorManagerImpl implements StatisticsGeneratorManager {

    @Resource
    private StatisticsGeneratorDao statisticsGeneratorDao;

    @Override
    public Map<String, Long> generateStatistics() {        
        Map<String, Long> statistics = new HashMap<String, Long>();        
        statistics.put(StatisticsEnum.KEY_LIVE_IDS.value(), statisticsGeneratorDao.getLiveIds());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_EDUCATION_QUALIFICATION.value(), statisticsGeneratorDao.getAccountsWithEducationQualification());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_EMPLOYMENT.value(), statisticsGeneratorDao.getAccountsWithEmployment());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_INVITED_POSITION_DISTINCTION.value(), statisticsGeneratorDao.getAccountsWithInvitedPositionDistinction());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_MEMBERSHIP_SERVICE.value(), statisticsGeneratorDao.getAccountsWithMembershipService());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_FUNDING.value(), statisticsGeneratorDao.getAccountsWithFunding());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_EXTERNAL_ID.value(), statisticsGeneratorDao.getAccountsWithExternalId());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_PEER_REVIEW.value(), statisticsGeneratorDao.getAccountsWithPeerReview());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_PERSON_ID.value(), statisticsGeneratorDao.getAccountsWithPersonId());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_RESEARCH_RESOURCE.value(), statisticsGeneratorDao.getAccountsWithResearchResource());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_VERIFIED_EMAIL.value(), statisticsGeneratorDao.getAccountsWithVerifiedEmails());
        statistics.put(StatisticsEnum.KEY_IDS_WITH_WORKS.value(), statisticsGeneratorDao.getAccountsWithWorks());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_WORKS.value(), statisticsGeneratorDao.getNumberOfWorks());
        statistics.put(StatisticsEnum.KEY_UNIQUE_DOIS.value(), statisticsGeneratorDao.getNumberOfUniqueDOIs());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_EMPLOYMENT.value(), statisticsGeneratorDao.getNumberOfEmployment());
        statistics.put(StatisticsEnum.KEY_EMPLOYMENT_UNIQUE_ORG.value(), statisticsGeneratorDao.getNumberOfEmploymentUniqueOrg());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_EDUCATION_QUALIFICATION.value(), statisticsGeneratorDao.getNumberOfEducationQualification());
        statistics.put(StatisticsEnum.KEY_EDUCATION_QUALIFICATION_UNIQUE_ORG.value(), statisticsGeneratorDao.getNumberOfEducationQualificationUniqueOrg());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_INVITED_POSITION_DISTINCTION.value(), statisticsGeneratorDao.getNumberOfInvitedPositionDistinction());
        statistics.put(StatisticsEnum.KEY_INVITED_POSITION_DISTINCTION_UNIQUE_ORG.value(), statisticsGeneratorDao.getNumberOfInvitedPositionDistinctionUniqueOrg());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_MEMBERSHIP_SERVICE.value(), statisticsGeneratorDao.getNumberOfMembershipService());
        statistics.put(StatisticsEnum.KEY_MEMBERSHIP_SERVICE_UNIQUE_ORG.value(), statisticsGeneratorDao.getNumberOfMembershipServiceUniqueOrg());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_FUNDING.value(), statisticsGeneratorDao.getNumberOfFunding());
        statistics.put(StatisticsEnum.KEY_FUNDING_UNIQUE_ORG.value(), statisticsGeneratorDao.getNumberOfFundingUniqueOrg());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_PEER_REVIEW.value(), statisticsGeneratorDao.getNumberOfPeerReview());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_PERSON_ID.value(), statisticsGeneratorDao.getNumberOfPersonId());
        statistics.put(StatisticsEnum.KEY_NUMBER_OF_RESEARCH_RESOURCE.value(), statisticsGeneratorDao.getNumberOfResearchResource());
        
        return statistics;        
    }

}
