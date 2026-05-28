{{- define "mini-account-management.labels" -}}
app.kubernetes.io/name: {{ .Chart.Name }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}


labels:
  {{- include "mini-account-management.labels" . | nindent 4 }}