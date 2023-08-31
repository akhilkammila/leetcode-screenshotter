import requests
import json
import re
import time
import csv
import traceback
import os


CSRFTOKEN='--LEETCODE_CSRFTOKEN--' # also part of the leetcode cookies, can also paste the value from there.
COOKIE='--LEETCODE_COOKIES--'

url = "https://leetcode.com/graphql"

REGEX=r'https:\/\/leetcode\.com\/playground\/[A-Z0-9a-z]{6,12}\/shared'
PROBLEMS_CSV='data/problem_data.csv'

headers = {
  'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:107.0) Gecko/20100101 Firefox/107.0',
  'Accept': '*/*',
  'Accept-Language': 'en-US,en;q=0.5',
  'Accept-Encoding': 'utf-8',
  'content-type': 'application/json',
  'x-csrftoken': CSRFTOKEN,
  'Origin': 'https://leetcode.com',
  'Connection': 'keep-alive',
  'Cookie': COOKIE,
  'Sec-Fetch-Dest': 'empty',
  'Sec-Fetch-Mode': 'cors',
  'Sec-Fetch-Site': 'same-origin',
  'TE': 'trailers'
}

payload1="{\"query\":\"\\n    query officialSolution($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    solution {\\n      content\\n    }\\n  }\\n}\\n    \",\"variables\":{\"titleSlug\":\"$$$\"}}"

def getExt(lang):
  if lang=='cpp':
    return '.cpp'
  elif lang=='python3' or lang=='python':
    return '.py'
  elif lang=='java':
    return '.java'
  elif lang=='.javascript':
    return '.js'
  elif lang=='typescript':
    return '.ts'
  elif lang=='swift':
    return '.swift'
  elif lang=='ruby':
    return '.rb'
  else:
    return ''

def getName(i, lang):
  return lang+'-'+str(i)+getExt(lang)



with open(PROBLEMS_CSV, 'r') as file:
  csv_reader = csv.reader(file)

  # Convert the CSV reader object to a list of rows
  rows = list(csv_reader)

  # Access specific rows by index
  for row in rows[1:]:
    number = row[0]
    problem_title = row[1]
    titleSlug = row[2].split('/')[-2]

    # print('titleSlug')
    # print(titleSlug)


    payload1Cp=payload1.replace('$$$', titleSlug)

    try:
      response1 = requests.request("POST", url, headers=headers, data=payload1Cp)

      # print("response1")
      # print(response1.text)

      response1 = json.loads(response1.text)

      urls = re.findall(REGEX, response1['data']['question']['solution']['content'])

      # print("urls")
      # print(urls)

      payload2 = "{\"query\":\"query fetchPlayground {\\n  allPlaygroundCodes(uuid: \\\"$$$\\\") {\\n    code\\n    langSlug\\n    __typename\\n  }\\n}\\n\",\"variables\":{}}"

      # headers['Referer']='https://leetcode.com/playground/FcDpFu3c/shared'
      # print(payload2)
      # response = requests.request("POST", url, headers=headers, data=payload2)
      # time.sleep(1)
      # print("codes")
      # print(response)
      # print(response.text)

      for i, u in enumerate(urls):
        uuid=u.split('/')[-2]
        # print("uuid")
        # print(uuid)
        payload=payload2.replace('$$$', uuid)
        # print("payload")
        # print(payload)
        response = requests.request("POST", url, headers=headers, data=payload)
        # time.sleep(1)
        # print("codes")
        # print(response)
        # print(response.text)
        response=json.loads(response.text);
        for code in response['data']['allPlaygroundCodes']:
          # print("fileName")
          # print(getName(i, code['langSlug']))
          subfolder = ''
          num = int(number)
          if num < 1000: subfolder = '1-999'
          elif num < 2000: subfolder = '1000-1999'
          else: subfolder='2000-2999'

          folder = f"editorial_code/{subfolder}/{number.zfill(3) + '. ' +problem_title}"
          fullPath = folder + '/' + getName(i, code['langSlug'])
          
          if not os.path.exists(folder):
            os.makedirs(folder)

          with open(fullPath, 'w') as f:
            f.write(code['code'])
          
    except Exception as e:
      csv_file_path = "editorial_code/download_error.csv"
      with open(csv_file_path, "a", newline="") as file:
        csv_writer = csv.writer(file)
        csv_writer.writerow(row)



    # response = requests.request("POST", url, headers=headers, data=payload2)



    # print(response.text)
