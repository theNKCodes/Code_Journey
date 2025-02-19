# Google
import speech_recognition as sr


def main():

    r = sr.Recognizer()

    with sr.Microphone() as source:
        r.adjust_for_ambient_noise(source)

        print("Please say something")

        audio = r.listen(source)

        print("Recognizing Now .... ")

# recognize speech using google

        try:
            print("You have said \n" + r.recognize_google(audio))
            print("Audio Recorded Successfully \n ")
        except Exception as e:
            print("Error :  " + str(e))

        # write audio
        with open("recorded.wav", "wb") as f:
            f.write(audio.get_wav_data())


if __name__ == "__main__":
    main()


# # Amazon
# import boto3
# import time

# # AWS credentials and region configuration
# aws_access_key_id = 'YOUR_ACCESS_KEY'
# aws_secret_access_key = 'YOUR_SECRET_KEY'
# region_name = 'us-east-1'  # Change to your AWS region

# # Initialize the Amazon Transcribe client
# transcribe = boto3.client('transcribe', region_name=region_name,
#                           aws_access_key_id=aws_access_key_id,
#                           aws_secret_access_key=aws_secret_access_key)

# # Specify the S3 URI of your audio file
# s3_bucket = 'your-s3-bucket-name'
# s3_object_key = 'path-to-your-audio-file.wav'
# s3_uri = f's3://{s3_bucket}/{s3_object_key}'

# # Start the transcription job
# job_name = f'transcription-job-{int(time.time())}'  # Unique job name
# language_code = 'en-US'  # Language code (e.g., 'en-US' for US English)

# try:
#     response = transcribe.start_transcription_job(
#         TranscriptionJobName=job_name,
#         Media={'MediaFileUri': s3_uri},
#         MediaFormat='wav',
#         LanguageCode=language_code,
#     )

#     print("Transcription job started...")

#     # Wait for the transcription job to complete
#     while True:
#         status = transcribe.get_transcription_job(TranscriptionJobName=job_name)
#         if status['TranscriptionJob']['TranscriptionJobStatus'] in ['COMPLETED', 'FAILED']:
#             break
#         print("Transcription job is still in progress...")
#         time.sleep(10)

#     # Check if the job was successful
#     if status['TranscriptionJob']['TranscriptionJobStatus'] == 'COMPLETED':
#         transcription_uri = status['TranscriptionJob']['Transcript']['TranscriptFileUri']
#         print("Transcription job completed successfully.")
#         print("Transcription result URI:", transcription_uri)

#         # You can download and process the transcription result from the provided URI

#     else:
#         print("Transcription job failed.")

# except Exception as e:
#     print(f"Error: {str(e)}")





# #assemblyai
# import assemblyai as aai

# # replace with your API token
# aai.settings.api_key = f"c69f98807dba47fca8ef06ffcafd215b"

# # URL of the file to transcribe
# FILE_URL = "https://github.com/AssemblyAI-Examples/audio-examples/raw/main/20230607_me_canadian_wildfires.mp3"

# config = aai.TranscriptionConfig(speaker_labels=True)

# transcriber = aai.Transcriber()
# transcript = transcriber.transcribe(
#   FILE_URL,
#   config=config
# )

# for utterance in transcript.utterances:
#   print(f"Speaker {utterance.speaker}: {utterance.text}")
