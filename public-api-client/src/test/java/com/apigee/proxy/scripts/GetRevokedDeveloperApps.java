package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApigeePublicApiTest;

public class GetRevokedDeveloperApps extends ApigeePublicApiTest {

	@Test
	public void testGetRevokedDeveloperApps() {

		List<DeveloperApp> revokedApps = new ArrayList<DeveloperApp>();

		List<String> apps = getPublicApi().getApps();

		for (String appName : apps) {
			DeveloperApp app = getPublicApi().getApp(appName);
			List<Credential> credentials = app.getCredentials();
			for (Credential credential : credentials) {
				if (credential.getStatus().equals("revoked")) {
					revokedApps.add(app);
				}
			}
		}

		System.out.println(revokedApps);
	}
}
