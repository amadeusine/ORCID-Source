package org.orcid.core.manager.v3;

import java.util.Collection;

import javax.persistence.NoResultException;

import org.orcid.core.exception.DeactivatedException;
import org.orcid.core.exception.LockedException;
import org.orcid.core.exception.OrcidDeprecatedException;
import org.orcid.core.exception.OrcidNotClaimedException;
import org.orcid.jaxb.model.message.ScopePathType;
import org.orcid.jaxb.model.v3.release.common.VisibilityType;
import org.orcid.jaxb.model.v3.release.record.Email;
import org.orcid.jaxb.model.v3.release.record.Person;
import org.orcid.jaxb.model.v3.release.record.PersonalDetails;
import org.orcid.jaxb.model.v3.release.record.Record;
import org.orcid.jaxb.model.v3.release.record.WorkBulk;
import org.orcid.jaxb.model.v3.release.record.summary.ActivitiesSummary;
import org.orcid.persistence.jpa.entities.IdentifierTypeEntity;
import org.orcid.persistence.jpa.entities.SourceAwareEntity;

/**
 * 
 * @author Will Simpson
 *
 */
public interface OrcidSecurityManager {

    boolean isAdmin();

    boolean isPasswordConfirmationRequired();

    String getClientIdFromAPIRequest();

    void checkProfile(String orcid) throws NoResultException, OrcidDeprecatedException, OrcidNotClaimedException, LockedException, DeactivatedException;

    void checkSourceAndThrow(SourceAwareEntity<?> existingEntity);

    void checkSource(IdentifierTypeEntity existingEntity);

    void checkScopes(ScopePathType... requiredScopes);

    void checkClientAccessAndScopes(String orcid, ScopePathType... requiredScopes);

    void checkAndFilter(String orcid, VisibilityType element, ScopePathType requiredScope);

    void checkAndFilter(String orcid, Email email, ScopePathType requiredScope);
            
    void checkAndFilter(String orcid, Collection<? extends VisibilityType> elements, ScopePathType requiredScope);    
    
    void checkAndFilter(String orcid, WorkBulk workBulk, ScopePathType requiredScope);    
    
    void checkAndFilter(String orcid, ActivitiesSummary activities);

    void checkAndFilter(String orcid, PersonalDetails personalDetails);

    void checkAndFilter(String orcid, Person person);

    void checkAndFilter(String orcid, Record record);

    String getOrcidFromToken();
}
