package br.ufla.ecommerce.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;

import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.PackageResourceGuard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;

import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.PackageResourceGuard;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;

import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;

public class BasePage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Array de arquivos CSS que devem ser carregados pela página.
	 */
	private List<String> cssFiles;
	
	/**
	 * Array de arquivos JS que devem ser carregados pela página.
	 */
	private List<String> jsFiles;
	
	/**
	 * Mapa de arquivos de imagem que serão usados pela página.
	 */
	private Map<String, String> imgFiles;

	
	/**
	 * Controlador de permissões dos arquivos.
	 */
	private static IPackageResourceGuard resourceGuard = new PackageResourceGuard();


	/**
	 * Inicia a página base.
	 * 
	 * @param parameters parametros vindos do wicket
	 */
	public BasePage(final PageParameters parameters) {
		super(parameters);
		
		// instancia as listas de arquivos que devem ser carregados
		cssFiles = new ArrayList<String>();
		jsFiles = new ArrayList<String>();
		imgFiles = new HashMap<String, String>();
		
		try {
			// Checa quais arquivos devem ser carregados com a página.
			requestExternalFiles();
			// Cria o link das imagens com o HTML
			prepareImages();
			// Prepara a página para a renderização
			initialize();
		} catch (Exception e) {
			
		}
    }
	
	/**
	 * Inicializa a página.
	 * Aqui você deve instanciar todos os componentes do wicket que serão usados
	 * na página e mapeá-los a ações. Assim, sua página ficará responsiva a
	 * eventos.
	 *
	 */
	public void initialize() {
		Label label = new Label("teste", "teste");
		// Controla o formulário de busca de produtos
		Form form = new Form("search-form") {
			
			// O que acontecerá quando o usuário enviar o formulário.
			@Override
			protected void onSubmit() {
				
			}
		};
		
		add(form);
		add(label);
	}
	
	/**
	 * Inicializa a página.
	 * Aqui você deve instanciar todos os componentes do wicket que serão usados
	 * na página e mapeá-los a ações. Assim, sua página ficará responsiva a
	 * eventos.
	 *
	 */
	public void initialize() {
		Label label = new Label("teste", "teste");
		// Controla o formulário de busca de produtos
		Form form = new Form("search-form") {
			
			// O que acontecerá quando o usuário enviar o formulário.
			@Override
			protected void onSubmit() {
				
			}
		};
		
		add(form);
		add(label);
	}
	
	/**
	 * Função que deverá ser implementada pela página filha, caso ela necessite
	 * de algum arquivo externo que não foi incluido na página base.
	 * 
	 */
	public void requestExternalFiles() {
		// Lista de arquivos que devem ser carregados pela página base
		addCssFile("css/bootstrap.min.css");
		addCssFile("css/base.css");
		
		addJsFile("js/jquery-2.1.4.min.js");
		addJsFile("js/bootstrap.min.js");
		addJsFile("js/base.js");
		
		// addImg("logo", "imgs/logo.png");
		
		// addPermission("fonts/glyphicons-halflings-regular.woff2");
		// addImg("logo", "imgs/logo.png");
		
		// addPermission("fonts/glyphicons-halflings-regular.woff2");
		//addImg("logo", "imgs/logo.png");
	}
	
	/**
	 * Prepara as imagens adicionadas à página, para que elas carregem
	 * corretamente com a página.
	 */
	public void prepareImages() {
		// Adiciona cada imagem à página.
		for (String img : imgFiles.keySet()) {
			add(new Image(img, new PackageResourceReference(BasePage.class, imgFiles.get(img))));
		}
	}
	
	/**
	 * Adiciona um arquivo CSS que deve ser carregado com a página.
	 * @param cssFile caminho do arquivo que sera carregado.
	 * @param cssFile caminho do arquivo que sera carregado.
	 * @param cssFile diretorio do arquivo que sera carregado.
	 */
	public void addCssFile(String cssFile) {
		cssFiles.add(cssFile);
	}
	
	/**
	 * Adiciona um arquivo JavaScript que deve ser carregado com a página.
	 * @param jsFile caminho do arquivo que sera carregado.
	 * @param jsFile caminho do arquivo que sera carregado.
	 * @param jsFile diretorio do arquivo que sera carregado.
	 */
	public void addJsFile(String jsFile) {
		jsFiles.add(jsFile);
	}
	
	/**
	 * Adiciona uma imagem que deve ser carregada com a página.
	 * @param nome dado para a imagem, para linkar com o arquivo HTML.
	 * @param imgFile caminho da imagem que sera carregada.
	 * @param imgFile caminho da imagem que sera carregada.
	 * @param imgFile diretorio da imagem que sera carregada.
	 */
	public void addImg(String resource, String imgFile) {
		imgFiles.put(resource, imgFile);
	}
	

	/**
	 * Adiciona permissão de acesso a um arquivo.
	 * @param file caminho para o arquivo que receberá permissão de acesso.
	 * @deprecated
	 */
	public void addPermission(String resource) {
		resource = "br/ufla/ecommerce/views/"+resource;
		resourceGuard.accept(BasePage.class, resource);
	}


	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		// renderiza todos os arquivos JS
		for (String jsFile : jsFiles) {
			resourceGuard.accept(BasePage.class, "br/ufla/ecommerce/views/"+jsFile);
		}
		// renderiza todos os arquivos JS
		for (String jsFile : jsFiles) {
			JavaScriptResourceReference file = new JavaScriptResourceReference(BasePage.class, jsFile);
			response.render(JavaScriptReferenceHeaderItem.forReference(file));
		}
		// renderiza todos os arquivos CSS
		for (String cssFile : cssFiles) {
			resourceGuard.accept(BasePage.class, "br/ufla/ecommerce/views/"+cssFile);

			CssResourceReference file = new CssResourceReference(BasePage.class, cssFile);
			response.render(CssContentHeaderItem.forReference(file));
		}
	}
}
