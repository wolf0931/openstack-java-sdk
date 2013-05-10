package org.openstack.keystone.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Role;
import org.openstack.keystone.model.Roles;

public class RolesResource {
	
	private OpenStackClient client;
	
	public RolesResource(OpenStackClient client) {
		this.client = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(Role role) {
		return new Create(role);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Roles> {
		
		public List() {
			super(client, HttpMethod.GET, "/OS-KSADM/roles", null, Roles.class);
		}

	}
	
	public class Create extends OpenStackRequest<Role> {

		private Role role;
		
		public Create(Role role) {
			super(client, HttpMethod.POST, "/OS-KSADM/roles", Entity.json(role), Role.class);
			this.role = role;
		}
		
	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/OS-KSADM/roles/").append(id).toString(), null, Void.class);
		}
		
	}
	
}
