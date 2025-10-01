# Samrakshana_EI_Coding_Excercises
# Smart Office Design (2025–26)

This repository contains solutions for the Wx2 Smart Office Design exercises.

It demonstrates the application of software design patterns, OOP best practices, and SOLID principles with a focus on real-world smart facility management.


# Exercise 1 – Design Pattern Use Cases

The following design patterns have been implemented with separate projects:

**Creational Patterns**

Factory Method – Device Controller Factory

Dynamically creates controllers for devices (AC, Lights, Projector, etc.) without tightly coupling to concrete classes.

Singleton – Office Configuration Manager

Ensures a single instance of configuration (e.g., office hours, energy-saving thresholds, booking rules).

**Structural Patterns**

Adapter – IoT Device Integration

Adapts different sensor APIs (motion sensors, temperature sensors, light sensors) to a unified system interface.

Decorator – Smart Room Feature Enhancement

Dynamically adds extra features to rooms (e.g., voice assistant, energy monitoring, auto-dimming) without changing base code.

**Behavioral Patterns**

Mediator – Smart Room Coordinator

Coordinates communication between conference booking, occupancy detection, and energy management modules without direct dependencies.

Observer – Occupancy Notification System

Notifies subscribed devices (lights, AC, security) whenever occupancy status changes.

# Exercise 2 – Mini Project
Smart Office Facility Manager

A console-based application to manage a smart office environment, focusing on room booking, occupancy-based automation, and energy efficiency.

**Features**

Book and cancel conference rooms with time validations.

Detect occupancy and trigger automation (AC on/off, lights dimmed/brightened).

Prevent double booking of the same room.

System auto-adjusts environment settings based on occupancy.

Logging & error handling built in.

Reports (daily energy usage, room utilization).

**Design Patterns Applied**

Singleton → Central OfficeManager instance.

Factory → Creation of devices/rooms dynamically.

Adapter → Unifies different sensors & IoT device APIs.

Observer → Notifications for occupancy changes.

Mediator → Coordinates interactions between booking, occupancy, and devices.

**Tech Stack**

Language: Java

Paradigms: OOP, SOLID principles, Defensive Programming

Patterns: Creational, Structural, Behavioral

Execution: Console-based application
