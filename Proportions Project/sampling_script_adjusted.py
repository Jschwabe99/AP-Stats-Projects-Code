import csv
import random
import os

# Get the directory of the current script
script_dir = os.path.dirname(os.path.abspath(__file__))

# File paths for each grade
grade_files = {
    9: os.path.join(script_dir, 'grade9.csv'),
    10: os.path.join(script_dir, 'grade10.csv'),
    11: os.path.join(script_dir, 'grade11.csv'),
    12: os.path.join(script_dir, 'grade12.csv')
}

# If you want ~58 completes per grade at a 70% response rate,
# you should invite about 83 students per grade.
invites_per_grade = 83

sampled_emails = []

# Load and sample from each grade
for grade, file_path in grade_files.items():
    emails = []
    with open(file_path, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        next(reader)  # Skip header
        for row in reader:
            # Assumes the first column is the email address.
            email = row[0]
            emails.append(email)
    
    # Ensure we don't sample more than available.
    target_size = min(len(emails), invites_per_grade)
    
    if len(emails) < invites_per_grade:
        print(f"Warning: Grade {grade} has only {len(emails)} students. Sampling all available emails.")
    
    sampled = random.sample(emails, target_size)
    sampled_emails.extend(sampled)

# Save sampled emails to CSV
with open('survey_sample_emails.csv', 'w', newline='', encoding='utf-8') as f:
    writer = csv.writer(f)
    writer.writerow(['email'])  # Header for email list
    for email in sampled_emails:
        writer.writerow([email])

# Print all the sampled emails for easy copying or reference
print("Sampled emails:")
for email in sampled_emails:
    print(email)

print(f"\nTotal sampled emails: {len(sampled_emails)}")
