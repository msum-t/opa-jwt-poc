package prodreg
import future.keywords.if
import future.keywords.in

default allow = false

allow if{
  input.action == "post"
  input.resource.type == "products"
  input.subject.authorities[_]  == "ROLE_SALES"
}


allow if{
  input.action == "put"
  input.resource.type == "approver"
  input.subject.authorities[_]  == "ROLE_APPROVER"



}

allow if{
  input.action == "put"
  input.resource.type == "dealer"
  input.subject.authorities[_]  == "ROLE_DEALER"

}

allow if{
  input.action == "put"
  input.resource.type == "ops"
  input.subject.authorities[_]  == "ROLE_OPS"
}

allowed_role:=["ROLE_SALES","ROLE_APPROVER","ROLE_DEALER","ROLE_OPS"]
allowed_resource:=["products","approvedProductList","rejectedProductList"]
allowed_action :=["get","delete","put","post"]

allow if {
  input.action in allowed_action
  input.resource.type in allowed_resource
  input.subject.authorities[_] in allowed_role
}



