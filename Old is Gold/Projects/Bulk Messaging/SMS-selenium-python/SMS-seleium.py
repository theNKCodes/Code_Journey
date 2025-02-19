from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import openpyxl
import time
import sys

# Specify the path to the Brave browser executable on your system.
brave_executable_path = 'C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe'

# Initialize the Brave browser driver with the specified executable path.
options = webdriver.ChromeOptions()
options.binary_location = brave_executable_path
driver = webdriver.Chrome(options=options)

filex = openpyxl.load_workbook("D:\Code_Journey\Projects\Bulk Messaging\SMS-selenium-python\contact.xlsx")
sh = filex["Sheet1"]

print("*************************************************************")
print("SMS sending program...")
print("*************************************************************")
print("\n")

print("Please enter the limit from the excel file:")
st = int(input("1. Start point: "))
ed = int(input("2. End point: "))

driver.get('https://messages.google.com/web/conversations')

time.sleep(8)
print("Successfully scanned.....")
time.sleep(8)

# Use WebDriverWait for better element handling
fab_link = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-main-nav/div/mw-fab-link/a/span[4]')))
fab_link.click()
time.sleep(3)

driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-main-nav/div/mw-fab-link/a').click()
time.sleep(8)
WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-main-nav/div/mw-fab-link/a'))).click()
driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-new-conversation-container/div/mw-new-conversation-start-group-button/button').click()
time.sleep(5)
count = 0

while(st<=ed):
    cl = sh.cell(st,1)
    element = driver.find_element_by_xpath('//*[@id="mat-chip-list-0"]/div/input')
    element.send_keys(cl.value)
    time.sleep(1)
    driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-new-conversation-container/div/mw-contact-selector-button/button').click()
    # time.sleep(1)
    st+=1
    count+=1
time.sleep(2)
#Add message here
message = "Type message here....."
driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-new-conversation-container/mw-new-conversation-sub-header/div/div[2]/mw-contact-chips-input/button').click()
time.sleep(16)
messend = driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-conversation-container/div/div/mws-message-compose/div/div[2]/div/mws-autosize-textarea/textarea')
messend.send_keys(message)
time.sleep(4)
driver.find_element_by_xpath('/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-conversation-container/div/div/mws-message-compose/div/mws-message-send-button/button').click()
time.sleep(2)
print(f"{count} messages sent already..")

sys.exit()
