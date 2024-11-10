import matplotlib.pyplot as plt

# latency , number of la in evolve-sc
payments_0_percent = [
    (1, 0.482056977),
    (10, 1.076631468),
    (50, 3.729404223),
    (100, 5.441389502),
    (200, 10.421829403),
    (300, 15.111769459),
    (500, 42.962448936)
]

payments_0_percent2 = [
    (1, 0.482056977),
    (10, 0.823259934),
    (50, 2.045950882),
    (100, 2.438431942),
    (200, 4.362379763),
    (300, 6.873453216),
    (500, 10.369572579),
    (1000, 17.461829929)
]

payments_50_percent = [
    (1, 0.495463696),
    (10, 0.722395805),
    (50, 1.931576359),
    (100, 3.146871317),
    (200, 5.846870568),
    (300, 8.662710735),
    (500, 16.530830356),
    (1000, 39.073811242)
]

payments_100_percent = [
    (1, 0.502892639),
    (10, 1.468076989),
    (50, 3.56297003),
    (100, 5.121697459),
    (200, 12.831418656),
    (300, 17.975970098),
    (500, 35.461272873),
    #(1000, ) failed
]

x_0_values = [point[0] for point in payments_0_percent2]
y_0_values = [point[1] for point in payments_0_percent2]

x_50_values = [point[0] for point in payments_50_percent]
y_50_values = [point[1] for point in payments_50_percent]

x_100_values = [point[0] for point in payments_100_percent]
y_100_values = [point[1] for point in payments_100_percent]

plt.figure(figsize=(6, 4))

plt.plot(x_0_values, y_0_values, marker='o', linestyle='-', color='b', label='No due payments')

plt.plot(x_50_values, y_50_values, marker='o', linestyle='-', color='g', label='50% due Payments')

plt.plot(x_100_values, y_100_values, marker='o', linestyle='-', color='r', label='100% due Payments')

plt.xlim(0, max(max(x_0_values), max(x_50_values), max(x_100_values), 1100))

plt.xticks(range(0, 1100, 100))  # Add 500 to the x-axis ticks

plt.xlabel('Number of LA-SC associated with Evolve-SC')
plt.ylabel('Latency (sec)')
plt.title('Latency analysis of the ARC-Oracle')
plt.legend()

# Show grid
plt.grid(True)

# Display the plot
plt.show()
