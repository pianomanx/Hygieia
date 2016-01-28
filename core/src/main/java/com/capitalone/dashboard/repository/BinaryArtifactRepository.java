package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.BinaryArtifact;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BinaryArtifactRepository extends CrudRepository<BinaryArtifact, ObjectId> {

    Iterable<BinaryArtifact> findByCollectorItemId(ObjectId collectorItemId);

    Iterable<BinaryArtifact> findByArtifactGroupIdAndArtifactNameAndArtifactVersion(String artifactGroupId, String artifactName, String artifactVersion);

    Iterable<BinaryArtifact> findByArtifactName(String artifactName);

    Iterable<BinaryArtifact> findByArtifactNameAndArtifactVersion(String artifactName, String artifactVersion);

    Iterable<BinaryArtifact> findByArtifactGroupId(String artifactGroupId);

    @Query(value="{'buildInfo.id' : ?0}")
    Iterable<BinaryArtifact> findByArtifactBuildId (ObjectId artifactBuildId);

}
