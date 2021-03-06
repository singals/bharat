# frozen_string_literal: true

class PurchasesController < ApplicationController
  include PurchasesHelper

  before_action :set_purchase, only: [:show, :edit, :update, :destroy]

  # GET /purchases
  # GET /purchases.json
  def index
    @purchases = Purchase.all
  end

  # GET /purchases/1
  # GET /purchases/1.json
  def show
    @articles = Article.where(is_active: true)
  end

  # GET /purchases/new
  def new
    @purchase = Purchase.new
    @purchase.purchase_items.build
    @articles = Article.where(is_active: true)
  end

  # POST /purchases
  # POST /purchases.json
  def create
    @purchase = Purchase.new(purchase_params)
    # TODO: adjust creditor's account for CREDIT purchase

    respond_to do |format|
      if save_new_purchase_order(@purchase)
        format.html { redirect_to @purchase, notice: 'Purchase was successfully created.' }
        format.json { render :show, status: :created, location: @purchase }
      else
        format.html { render :new }
        format.json { render json: @purchase.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /purchases/1
  # DELETE /purchases/1.json
  def destroy
    # TODO: adjust stock
    # TODO adjust creditor's account for CREDIT purchase
    @purchase.destroy
    respond_to do |format|
      format.html { redirect_to purchases_url, notice: 'Purchase was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private

  # Use callbacks to share common setup or constraints between actions.
  def set_purchase
    @purchase = Purchase.find(params[:id])
    @purchase.purchase_items ||= []
  end

  # Never trust parameters from the scary internet, only allow the white list through.
  def purchase_params
    params.require(:purchase).permit(:seller_name, :city, :phone, :invoice_number, :total_cost,
                                     purchase_items_attributes: [:article_id, :purchase_id, :quantity, :price, :cost])
  end
end
