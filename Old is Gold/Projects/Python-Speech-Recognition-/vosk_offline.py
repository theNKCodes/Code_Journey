import vosk

model = vosk.Model('vosk-model-small-en-us-0.15')
rec = vosk.Recognizer(model)
  
import pyaudio

with pyaudio.PyAudio() as audio:
    stream = audio.open(...)
    while stream.is_active():
        data = stream.read(4000)
        if len(data) == 0:
            break
        if rec.AcceptWaveform(data):
            result = json.loads(rec.Result())