package com.framework.common;

import com.framework.configuration.WebdriverInitialization;

public class WebpageCommomOperation extends WebdriverInitialization{

	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void openApplication(String url ) {
		driver.get(url);
	}
}
