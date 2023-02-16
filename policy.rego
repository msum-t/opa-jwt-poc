package authz

default allow = false

#Hr allowed to view everyons salary
allow {
  input.action == "read"
  input.resource.type == "salary"
  input.subject.authorities[_] == "ROLE_HR"
}

#own salary
allow {
  input.action == "read"
  input.resource.type == "salary"
  input.resource.user == users_access[input.subject.name][_]
}

#allowed for own docs
allow {
  input.action == "read"
  input.resource.type == "document"
  input.resource.owner == input.subject.name
}

#access for there reporting person
users_graph[data.users[username].name] = edges {
  edges := data.users[username].subordinates
}

users_access[username] = access {
  users_graph[username]
  access := graph.reachable(users_graph, {username})
}


#[
#  {"name": "alice", "subordinates": ["bob", "john"]},
#  {"name": "bob", "subordinates": ["carol", "david"]},
#  {"name": "carol", "subordinates": []},
#  {"name": "david", "subordinates": []},
#  {"name": "john", "subordinates": []}
#]