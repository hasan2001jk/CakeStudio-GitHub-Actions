# k8smaster
output "internal_ip_address_k8smaster" {
  value = yandex_compute_instance.k8smaster.network_interface.0.ip_address
}

output "external_ip_address_k8smaster" {
  value = yandex_compute_instance.k8smaster.network_interface.0.nat_ip_address
}


# k8sworker
output "internal_ip_address_k8sworker" {
  value = yandex_compute_instance.k8sworker.network_interface.0.ip_address
}

output "external_ip_address_k8sworker" {
  value = yandex_compute_instance.k8sworker.network_interface.0.nat_ip_address
}

# sonarqube
output "internal_ip_address_sonarqube" {
  value = yandex_compute_instance.sonarqube.network_interface.0.ip_address
}

output "external_ip_address_sonarqube" {
  value = yandex_compute_instance.sonarqube.network_interface.0.nat_ip_address
}
