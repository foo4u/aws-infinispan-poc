# Infinispan on AWS Elastic Container Service

Proof of concept getting Inifinispan clustering working with Wildfly on Amazon's
Elastic Container Service (ECS). ECS is an Amazon proprietary deployment platform
for Docker with similarities to Kubernetes, etc.

Infinispan is a distributed in-memory key/value data store, relying on JGroups for
node communication.

Before doing an Infinispan POC, we wanted to get JGroups working without issue.
See `ecs-jgroups-poc` for more information.

