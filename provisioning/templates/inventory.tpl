[master]
master ansible_host=${master_node_external_ip}

[worker]
worker ansible_host=${worker_node_external_ip}

[sonarqube]
sonarqube ansible_host=${sonarqube_node_external_ip}

