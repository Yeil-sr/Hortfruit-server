package com.hortfruit.address.service;

import com.hortfruit.address.dto.AddressDTO;
import com.hortfruit.address.model.Address;
import com.hortfruit.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Método para criar um novo endereço
    public Address createAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setRua(addressDTO.getRua());
        address.setNumero(addressDTO.getNumero());
        address.setCidade(addressDTO.getCidade());
        address.setBairro(addressDTO.getBairro());
        address.setEstado(addressDTO.getEstado());
        address.setCep(addressDTO.getCep());
        address.setComplemento(addressDTO.getComplemento());
        address.setReferencia(addressDTO.getReferencia());
        return addressRepository.save(address);
    }

    // Método para buscar um endereço pelo ID
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Método para atualizar um endereço existente
    public Address updateAddress(Long id, AddressDTO addressDTO) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setRua(addressDTO.getRua());
            address.setNumero(addressDTO.getNumero());
            address.setCidade(addressDTO.getCidade());
            address.setBairro(addressDTO.getBairro());
            address.setEstado(addressDTO.getEstado());
            address.setCep(addressDTO.getCep());
            address.setComplemento(addressDTO.getComplemento());
            address.setReferencia(addressDTO.getReferencia());
            return addressRepository.save(address);
        }
        return null; // Retorna null se o endereço não existir
    }

    // Método para deletar um endereço pelo ID
    public boolean deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
