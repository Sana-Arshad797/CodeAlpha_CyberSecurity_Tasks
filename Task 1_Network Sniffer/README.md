# Basic Network Sniffer

A simple Python-based network packet sniffer created during my Cyber Security internship at CodeAlpha. It captures network traffic packets and extracts basic details like IP addresses, protocols, and payloads.

## Features
- Captures live network packets.
- Extracts Source and Destination IP addresses.
- Identifies protocols (TCP, UDP, ICMP).
- Displays raw payload data.

## Requirements
Make sure you have Python installed. If you are using Scapy, install it via pip:
```bash
pip install scapy
```

## How to Run

> **Note:** Packet sniffing requires root/administrator privileges.

### Linux / macOS
```bash
sudo python3 sniffer.py
```

### Windows
Open Command Prompt as **Administrator** and run:
```cmd
python sniffer.py
```

## Output Example
```text
[*] Sniffer started... Listening for packets.

[+] Packet: 192.168.1.15 -> 142.250.190.46 | Protocol: TCP | Ports: 53214 -> 443
Payload: b'\x16\x03\x01\x02\x00\x01...'
------------------------------------------------------------------
```

## Disclaimer
This project is only for educational purposes and authorized security testing. Do not use it on networks without permission.
