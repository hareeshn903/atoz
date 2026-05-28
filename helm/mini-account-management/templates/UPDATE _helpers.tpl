{{- define "mini-account-management.name" -}}
{{ .Chart.Name }}
{{- end }}

{{- define "mini-account-management.fullname" -}}
{{ .Release.Name }}-{{ .Chart.Name }}
{{- end }}