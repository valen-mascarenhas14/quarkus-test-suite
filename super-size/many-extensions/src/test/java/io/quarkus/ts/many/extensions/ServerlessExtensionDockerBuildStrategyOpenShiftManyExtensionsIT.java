package io.quarkus.ts.many.extensions;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import io.quarkus.test.scenarios.OpenShiftDeploymentStrategy;
import io.quarkus.test.scenarios.OpenShiftScenario;
import io.restassured.specification.RequestSpecification;

@Disabled("https://github.com/quarkusio/quarkus/issues/37855")
@DisabledIfSystemProperty(named = "ts.arm.missing.services.excludes", matches = "true", disabledReason = "https://github.com/quarkus-qe/quarkus-test-suite/issues/1142")
@Tag("use-quarkus-openshift-extension")
@Tag("serverless")
@OpenShiftScenario(deployment = OpenShiftDeploymentStrategy.UsingOpenShiftExtensionAndDockerBuildStrategy)
public class ServerlessExtensionDockerBuildStrategyOpenShiftManyExtensionsIT extends ManyExtensionsIT {
    private RequestSpecification HTTPS_CLIENT_SPEC = given().relaxedHTTPSValidation();

    @Override
    protected RequestSpecification givenSpec() {
        return HTTPS_CLIENT_SPEC;
    }
}
