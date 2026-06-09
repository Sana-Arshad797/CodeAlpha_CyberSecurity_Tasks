from scapy.all import sniff, IP, TCP, UDP, ICMP

# TASK 1 Requirement: Analyze captured packets and extract useful information
def process_packet(packet):
    # Check if the packet contains an IP layer (Source/Destination IPs)
    if packet.haslayer(IP):
        src_ip = packet[IP].src   # Source IP
        dst_ip = packet[IP].dst   # Destination IP
        proto_num = packet[IP].proto  # Protocol Number
        
        # TASK 1 Requirement: Identify the protocol structure
        protocol_name = "Other"
        if proto_num == 6:
            protocol_name = "TCP"
        elif proto_num == 17:
            protocol_name = "UDP"
        elif proto_num == 1:
            protocol_name = "ICMP (Ping)"

        print(f"\n[+] [{protocol_name}] Connection Detected:")
        print(f"    Source IP:      {src_ip}")
        print(f"    Destination IP: {dst_ip}")
        
        # TASK 1 Requirement: Extract and display payloads (Data)
        if packet.haslayer(TCP) or packet.haslayer(UDP):
            # Convert raw payload bytes into readable characters
            payload_data = bytes(packet[IP].payload)
            if payload_data:
                # Print the first 60 characters so it fits neatly in CMD
                print(f"    Payload Data:   {payload_data[:60]}")
            else:
                print("    Payload Data:   None (Empty Packet)")

print("=" * 60)
print("CodeAlpha Cyber Security Internship - Task 1: Network Sniffer")
print("Status: Active and capturing traffic... Press Ctrl+C to stop.")
print("=" * 60)

# TASK 1 Requirement: Build a Python program to capture network traffic packets
# store=False prevents memory overload on Windows
sniff(prn=process_packet, store=False)