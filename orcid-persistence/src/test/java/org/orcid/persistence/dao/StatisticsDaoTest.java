/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.orcid.persistence.jpa.entities.StatisticKeyEntity;
import org.orcid.persistence.jpa.entities.StatisticValuesEntity;
import org.orcid.test.OrcidJUnit4ClassRunner;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(OrcidJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:statistics-persistence-context.xml" })
public class StatisticsDaoTest {

    @Resource
    StatisticsDao statisticsDao;

    @Resource
    StatisticsGeneratorDao statisticsGeneratorDao;

    @Test
    @Rollback(true)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testStatistics() {
        StatisticKeyEntity key = statisticsDao.createKey();
        
        StatisticValuesEntity os1 = new StatisticValuesEntity(key, "s1", 11);
        StatisticValuesEntity os2 = new StatisticValuesEntity(key, "s2", 3);
        StatisticValuesEntity os3 = new StatisticValuesEntity(key, "s3", 12);
        StatisticValuesEntity os4 = new StatisticValuesEntity(key, "s4", 7);
        StatisticValuesEntity os5 = new StatisticValuesEntity(key, "s5", 0);
        StatisticValuesEntity os6 = new StatisticValuesEntity(key, "s6", 0);
        StatisticValuesEntity os7 = new StatisticValuesEntity(null, "s7", 0);        

        statisticsDao.persist(os1);
        statisticsDao.persist(os2);
        statisticsDao.persist(os3);
        statisticsDao.persist(os4);
        statisticsDao.persist(os5);
        statisticsDao.persist(os6);
        statisticsDao.persist(os7);

        StatisticKeyEntity latestKey = statisticsDao.getLatestKey();

        assertEquals(key, latestKey);

        List<StatisticValuesEntity> statistics = statisticsDao.getStatistic(latestKey.getId());

        assertNotNull(statistics);
        assertEquals(statistics.size(), 5);
        assertTrue(statistics.contains(os1));
        assertTrue(statistics.contains(os2));
        assertTrue(statistics.contains(os3));
        assertTrue(statistics.contains(os4));
        assertTrue(statistics.contains(os5));
        assertFalse(statistics.contains(os6));
        assertFalse(statistics.contains(os7));
    }
}
