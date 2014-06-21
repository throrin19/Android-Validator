package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.R;

public class IPAddressValidator extends AbstractValidator {

	private static final String IPADDRESS_STRING_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private static final Pattern IPADDRESS_PATTERN = Pattern
			.compile(IPADDRESS_STRING_PATTERN);

	private static final int DEFAULT_ERROR_MESSAGE_RESOURCE = R.string.validator_ip;

	public IPAddressValidator(Context c) {
		super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
	}

	@Override
	public boolean isValid(String ip) {
		Matcher matcher = IPADDRESS_PATTERN.matcher(ip);
		return matcher.matches();
	}
}
