package com.lawencon.asongan.service;

import java.util.List;

import com.lawencon.asongan.model.Transaksi;

public interface TransaksiService {
	Transaksi addTransaksi(Transaksi transaksi);	
	List<Transaksi> getAll();
}
