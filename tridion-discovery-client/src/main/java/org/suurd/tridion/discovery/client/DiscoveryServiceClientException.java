package org.suurd.tridion.discovery.client;

/**
 * Exception typically thrown after catching and handling an exception within
 * the discovery service client.
 * 
 * @author jsuurd
 */
public class DiscoveryServiceClientException extends RuntimeException {

	private static final long serialVersionUID = -4134591130115494695L;

	/**
	 * Constructs a new discovery service client exception with the specified message.
	 * 
	 * @param message the message 
	 */
	public DiscoveryServiceClientException(String message) {
		super(message);
	}

	/**
	 * Constructs a new discovery service client exception with the specified message and
	 * cause.
	 * 
	 * @param message the message 
	 * @param cause the cause
	 */
	public DiscoveryServiceClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
