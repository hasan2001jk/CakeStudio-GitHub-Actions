terraform {
  required_providers {
    yandex = {
      source = "yandex-cloud/yandex"
    }
  }

  backend "s3" {
    endpoints = {
      s3 = "https://storage.yandexcloud.net"
    }
    bucket = "my-tf-log-bucket"
    region = "ru-central1"
    key    = "terraform.tfstate"

    skip_region_validation      = true
    skip_credentials_validation = true
    skip_requesting_account_id  = true # Необходимая опция Terraform для версии 1.6.1 и старше.
    skip_s3_checksum            = true # Необходимая опция при описании бэкенда для Terraform версии 1.6.3 и старше.

  }

}
 
provider "yandex" {
  token  = var.yandex_token
  cloud_id  = var.yandex_cloud_id
  folder_id = "b1g5enj0v0e6600a5o4a"
  zone      = "ru-central1-a"
} 



# K8S-master
resource "yandex_compute_instance" "k8smaster" {
    name = "k8smaster"  
    allow_stopping_for_update = "true"    

    platform_id = "standard-v1"

    boot_disk {
        initialize_params {
            image_id = var.image-id
	    size =50 
        }
	
    }

     resources {
      core_fraction = 5
      cores  = 2
      memory = 4
    }

  network_interface {
    subnet_id = yandex_vpc_subnet.subnet-1.id
    nat       = true
  }


  metadata = {
    ssh-keys = "ubuntu:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDLc9h3DFb2ZWKDP/mS7GBA5JT5Da3Pd3zfoMgrHoaA7WkJkHfysJa6JeW+apSi+ob9bEcAJjK+DEzaPKltiVvIwwGD5ip7d/UOEJgodi1PVQsYusjt81/zUi8+UT308Izi4y1DxQhm3zIJI2R11Nk5iA1hZa7WuZFFxfocYVCirv/tqOHEwZwgGW7Qc4Qb/wyOYtERkK47pAsI05QrkMiiWdEfQlkfP8GquEBpjDmxSWE5/bc/w4tRUWAEIIv45RKiuY77ODJfAZMfLgphmuz5rrIdO9DvO74rkM41LAJUJG+h5HicZprUdef83AAIJTB7iZw2GWZYHw5Aiw3EAEfDHYloyWKT1ZgenhfbW/BBGmxm+SBOzyYIYrP9o67ut41PKXHnctlIZAIAq0DQ5eE9e9njWDVi/sXWsP52MGVmihRYtM/dGlv3PfY4VxfVLIN3iGWwdLnA7rgOBi7Ztw+fXGg0Yv63me4OWhGbvFXPdUy1a79XxMRjfzz+oRE2FHk= root@st17-HP-EliteDesk-800-G1-SFF"
  }

}




# K8S-master
resource "yandex_compute_instance" "k8sworker" {
    name = "k8sworker"  
    allow_stopping_for_update = "true"    

    platform_id = "standard-v1"

    boot_disk {
        initialize_params {
            image_id = var.image-id
	    size =50 
        }
	
    }

     resources {
      core_fraction = 5
      cores  = 2
      memory = 4
    }

  network_interface {
    subnet_id = yandex_vpc_subnet.subnet-1.id
    nat       = true
  }


  metadata = {
    ssh-keys = "ubuntu:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDLc9h3DFb2ZWKDP/mS7GBA5JT5Da3Pd3zfoMgrHoaA7WkJkHfysJa6JeW+apSi+ob9bEcAJjK+DEzaPKltiVvIwwGD5ip7d/UOEJgodi1PVQsYusjt81/zUi8+UT308Izi4y1DxQhm3zIJI2R11Nk5iA1hZa7WuZFFxfocYVCirv/tqOHEwZwgGW7Qc4Qb/wyOYtERkK47pAsI05QrkMiiWdEfQlkfP8GquEBpjDmxSWE5/bc/w4tRUWAEIIv45RKiuY77ODJfAZMfLgphmuz5rrIdO9DvO74rkM41LAJUJG+h5HicZprUdef83AAIJTB7iZw2GWZYHw5Aiw3EAEfDHYloyWKT1ZgenhfbW/BBGmxm+SBOzyYIYrP9o67ut41PKXHnctlIZAIAq0DQ5eE9e9njWDVi/sXWsP52MGVmihRYtM/dGlv3PfY4VxfVLIN3iGWwdLnA7rgOBi7Ztw+fXGg0Yv63me4OWhGbvFXPdUy1a79XxMRjfzz+oRE2FHk= root@st17-HP-EliteDesk-800-G1-SFF"
  }

}


# SonarQube Server
resource "yandex_compute_instance" "sonarqube" {
  name                      = "sonarqube"
  allow_stopping_for_update = "true"

  platform_id = "standard-v1"

  boot_disk {
    initialize_params {
      image_id = var.image-id
      size     = 50
    }

  }

  resources {
    core_fraction = 5
    cores         = 4
    memory        = 4
  }

  network_interface {
    subnet_id = yandex_vpc_subnet.subnet-1.id
    nat       = true
  }


  metadata = {
    ssh-keys = "ubuntu:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDLc9h3DFb2ZWKDP/mS7GBA5JT5Da3Pd3zfoMgrHoaA7WkJkHfysJa6JeW+apSi+ob9bEcAJjK+DEzaPKltiVvIwwGD5ip7d/UOEJgodi1PVQsYusjt81/zUi8+UT308Izi4y1DxQhm3zIJI2R11Nk5iA1hZa7WuZFFxfocYVCirv/tqOHEwZwgGW7Qc4Qb/wyOYtERkK47pAsI05QrkMiiWdEfQlkfP8GquEBpjDmxSWE5/bc/w4tRUWAEIIv45RKiuY77ODJfAZMfLgphmuz5rrIdO9DvO74rkM41LAJUJG+h5HicZprUdef83AAIJTB7iZw2GWZYHw5Aiw3EAEfDHYloyWKT1ZgenhfbW/BBGmxm+SBOzyYIYrP9o67ut41PKXHnctlIZAIAq0DQ5eE9e9njWDVi/sXWsP52MGVmihRYtM/dGlv3PfY4VxfVLIN3iGWwdLnA7rgOBi7Ztw+fXGg0Yv63me4OWhGbvFXPdUy1a79XxMRjfzz+oRE2FHk= root@st17-HP-EliteDesk-800-G1-SFF"
  }

}





resource "yandex_vpc_network" "network-1" {
    name = "from-terraform-network"
} 


resource "yandex_vpc_subnet" "subnet-1" {
    name           = "from-final-project-subnet"
    zone           = "ru-central1-a"
    network_id     = yandex_vpc_network.network-1.id
    v4_cidr_blocks = ["10.2.0.0/16"]
}

variable "yandex_token" {
  description = "Yandex Cloud token"
}

variable "yandex_cloud_id" {
  description = "Yandex Cloud ID"
}

variable "ssh_public_key" {
  description = "SHH Public Key"
  sensitive = true
}



resource "local_file" "inventory_tmpl" {
  content = templatefile("${path.module}/templates/inventory.tpl",
    {
      master_node_external_ip = yandex_compute_instance.k8smaster.network_interface.0.nat_ip_address
      worker_node_external_ip = yandex_compute_instance.k8sworker.network_interface.0.nat_ip_address
      sonarqube_node_external_ip = yandex_compute_instance.sonarqube.network_interface.0.nat_ip_address
    }
  )
  filename = "../configuring/inventory"
}




