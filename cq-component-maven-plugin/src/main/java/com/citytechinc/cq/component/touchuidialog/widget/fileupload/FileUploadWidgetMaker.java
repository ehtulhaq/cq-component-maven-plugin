package com.citytechinc.cq.component.touchuidialog.widget.fileupload;

import com.citytechinc.cq.component.annotations.widgets.Html5SmartFile;
import com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException;
import com.citytechinc.cq.component.touchuidialog.TouchUIDialogElement;
import com.citytechinc.cq.component.touchuidialog.TouchUIDialogType;
import com.citytechinc.cq.component.touchuidialog.exceptions.TouchUIDialogGenerationException;
import com.citytechinc.cq.component.touchuidialog.widget.maker.AbstractTouchUIWidgetMaker;
import com.citytechinc.cq.component.touchuidialog.widget.maker.TouchUIWidgetMakerParameters;
import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class FileUploadWidgetMaker extends AbstractTouchUIWidgetMaker<FileUploadWidgetParameters> {

    public FileUploadWidgetMaker(TouchUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public TouchUIDialogElement make(FileUploadWidgetParameters widgetParameters) throws ClassNotFoundException,
        InvalidComponentFieldException, TouchUIDialogGenerationException {
        Html5SmartFile smartFileAnnotation = getAnnotation(Html5SmartFile.class);

        widgetParameters.setTitle(getTitleForField(smartFileAnnotation));
        widgetParameters.setAsync(getAsyncForField(smartFileAnnotation));
        widgetParameters.setText(getTextForField(smartFileAnnotation));
        widgetParameters.setHideText(getHideTextForField(smartFileAnnotation));
        widgetParameters.setIcon(getIconForField(smartFileAnnotation));
        widgetParameters.setIconSize(getIconSizeForField(smartFileAnnotation));
        widgetParameters.setSize(getSizeForField(smartFileAnnotation));
        widgetParameters.setMultiple(getMultipleForField(smartFileAnnotation));
        widgetParameters.setAllowUpload(getAllowUploadForField(smartFileAnnotation));
        widgetParameters.setUploadUrl(getUploadUrlForField(smartFileAnnotation));
        widgetParameters.setUploadUrlBuilder(getUploadUrlBuilderForField(smartFileAnnotation));
        widgetParameters.setSizeLimit(getSizeLimitForField(smartFileAnnotation));
        widgetParameters.setAutoStart(getAutoStartForField(smartFileAnnotation));
        widgetParameters.setUseHTML5(getUseHTML5ForField(smartFileAnnotation));
        widgetParameters.setDropZone(getDropZoneForField(smartFileAnnotation));
        widgetParameters.setMimeTypes(getMimeTypesForField(smartFileAnnotation));
        widgetParameters.setFileNameParameter(getFileNameParameterForField(smartFileAnnotation));
        widgetParameters.setFileReferenceParameter(getFileReferenceParameterForField(smartFileAnnotation));
        widgetParameters.setTouchUIDialogType(parameters.getTouchUIDialogType());

        if (TouchUIDialogType.CORAL3.isOfType(widgetParameters.getTouchUIDialogType())) {
            return new FileUploadCoral3Widget(widgetParameters);
        }
        return new FileUploadWidget(widgetParameters);
    }

    public String getTitleForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.title())) {
            return annotation.title();
        }

        return null;
    }

    public boolean getAsyncForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.async();
        }

        return false;
    }

    public String getTextForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.text())) {
            return annotation.text();
        }

        return null;
    }

    public boolean getHideTextForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.hideText();
        }

        return false;
    }

    public String getIconForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.icon())) {
            return annotation.icon();
        }

        return null;
    }

    public boolean getAllowUploadForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.allowUpload();
        }

        return false;
    }

    public String getIconSizeForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.iconSize())) {
            return annotation.iconSize();
        }

        return null;
    }

    public String getSizeForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.size())) {
            return annotation.size();
        }

        return null;
    }

    public boolean getMultipleForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.multiple();
        }

        return false;
    }

    public String getUploadUrlForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.uploadUrl())) {
            return annotation.uploadUrl();
        }

        return null;
    }

    public String getUploadUrlBuilderForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.uploadUrlBuilder())) {
            return annotation.uploadUrlBuilder();
        }

        return null;
    }

    public Long getSizeLimitForField(Html5SmartFile annotation) {
        if (annotation != null && annotation.sizeLimit() != 0) {
            return Long.valueOf(annotation.sizeLimit());
        }

        return null;
    }

    public boolean getAutoStartForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.autoStart();
        }

        return false;
    }

    public boolean getUseHTML5ForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.useHtml5();
        }

        return true;
    }

    public String getDropZoneForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.dropZone())) {
            return annotation.dropZone();
        }

        return null;
    }

    public List<String> getMimeTypesForField(Html5SmartFile annotation) {
        if (annotation != null && annotation.touchUIMimeTypes().length > 0) {
            return Arrays.asList(annotation.touchUIMimeTypes());
        }

        return null;
    }

    private String getFileReferenceParameterForField(Html5SmartFile smartFileAnnotation) {
        return smartFileAnnotation.fileReferenceParameter();
    }

    private String getFileNameParameterForField(Html5SmartFile smartFileAnnotation) {
        return smartFileAnnotation.fileNameParameter();
    }
}