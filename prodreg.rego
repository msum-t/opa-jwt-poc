package prodreg
import future.keywords.if
import future.keywords.in

default allow = false

allow if{
  input.action == "create"
  input.resource.type == "create-product"
  input.subject.authorities[_]  == "ROLE_SALES"
}


allow if{
  input.action == "approved"
  input.resource.type == "approve-product"
  input.subject.authorities[_]  == "ROLE_APPROVER"

}

allow if{
  input.action == "read"
  input.resource.type == "dealer"
  input.subject.authorities[_]  == "ROLE_DEALER"

}

allow if{
  input.action == "remove"
  input.resource.type == "ops"
  input.subject.authorities[_]  == "ROLE_OPS"
}

allowed_role:=["ROLE_SALES","ROLE_APPROVER","ROLE_DEALER","ROLE_OPS"]
allowed_resource:=["reject-product-list","approved-product-list"]

allow if{
  input.action == "read"
  input.resource.type in allowed_resource
  input.subject.authorities[_] in allowed_role
}



