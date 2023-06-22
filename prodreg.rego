package prodreg
import future.keywords.if
import future.keywords.in

default allow = false

allow {
  input.action == "post"
  input.resource.type == "create-product"
  input.subject.authorities[_]  == "ROLE_SALES"
}


allow {
  input.action == "put"
  input.resource.type == "approver"
  input.subject.authorities[_]  == "ROLE_APPROVER"
}

allow {
  input.action == "put"
  input.resource.type == "dealer"
  input.subject.authorities[_]  == "ROLE_DEALER"

}

allow {
  input.action == "put"
  input.resource.type == "ops"
  input.subject.authorities[_]  == "ROLE_OPS"

}

allowed_role:=["ROLE_SALES","ROLE_APPROVER","ROLE_DEALER","ROLE_OPS"]
allowed_resource:=["products","approvedProductList","rejectedProductList"]
allowed_action :=["get","delete","put","post"]
allow  {
  input.action in allowed_action
  input.resource.type in allowed_resource
  input.subject.authorities[_] in allowed_role
}


allow {
  input.action in allowed_action
  input.resource.type == "getProductColumn"
  input.subject.authorities[_] in allowed_role
}

allow{
    input.authorities[i]==data.allowed_columns_for_roles.user_roles[_]
    generate_columns := [c |
        role := input.authorities[_]
        columns := data.allowed_columns_for_roles.roles_column[role]
        c := columns[_]
    ]

    sort(generate_columns) == sort(input.resourceAttributes.columnValue)
}


